#[derive(Debug, PartialEq)]
pub enum Error {
    NotEnoughPinsLeft,
    GameComplete,
}

#[derive(Debug)]
pub struct Frame {
    pub rolls: Vec<u16>,
}

#[derive(Debug)]
pub struct BowlingGame {
    pub frames: Vec<Frame>,
}

pub fn is_strike(frame: &Frame) -> bool {
    return frame.rolls.get(0) == Some(&10);
}

pub fn is_spare(frame: &Frame) -> bool {
    let sum = _sum(&frame.rolls);
    frame.rolls.len() == 2 && sum == 10
}

pub fn is_open(frame: &Frame) -> bool {
    let sum = _sum(&frame.rolls);
    frame.rolls.len() == 2 && sum < 10
}

pub fn has_fill_ball(frame: &Frame) -> bool {
    frame.rolls.len() == 3
}

pub fn _sum(arr: &Vec<u16>) -> u16 {
    arr.iter().fold(0, |a, &b| a + b)
}

impl BowlingGame {

    pub fn new() -> Self {
        BowlingGame {
            frames: Vec::<Frame>::new(),
        }
    }

    pub fn roll(&mut self, pins: u16) -> Result<(), Error> {
        if pins > 10 {
            return Err(Error::NotEnoughPinsLeft);
        }

        if self.frames.len() == 10 { 
            let last_frame = self.frames.last_mut().unwrap();

            if is_strike(last_frame) &&
               last_frame.rolls.len() == 2 &&
               last_frame.rolls[1] < 10 &&
               pins + last_frame.rolls[1] > 10 {
                return Err(Error::NotEnoughPinsLeft);
            }

            if is_strike(last_frame) &&
               last_frame.rolls.len() == 2 &&
               last_frame.rolls[1] < 10 &&
               pins == 10 {
                return Err(Error::NotEnoughPinsLeft);
            }

            if is_open(last_frame) || has_fill_ball(last_frame) {
                return Err(Error::GameComplete);
            }else {
                last_frame.rolls.push(pins);
            }
            return Ok(());
        }

        if pins == 10 {
            self.frames.push(Frame{
                rolls: vec![pins]
            });
            return Ok(());
        }

        let last_frame = match self.frames.last_mut() {
            Some(f) => {
                if is_strike(f) || is_spare(f) || is_open(f) {
                    Some(Frame{
                        rolls: vec![pins],
                    })    
                } else {
                    if pins + _sum(&f.rolls) > 10 {
                        return Err(Error::NotEnoughPinsLeft);
                    }
                    f.rolls.push(pins);
                    None
                }
            },
            None => {
                Some(Frame{
                    rolls: vec![pins],
                })
            }
        };
        if let Some(frm) = last_frame {
            self.frames.push(frm);
        }
        Ok(()) 
    }

    pub fn score(&self) -> Option<u16> {
        if self.frames.len() == 10 {
            if is_strike(&self.frames.last().unwrap()) &&
               self.frames.last().unwrap().rolls.len() < 3 {
                return None;
            }

            if is_spare(&self.frames.last().unwrap()) &&
               self.frames.last().unwrap().rolls.len() < 3 {
                return None;
            }

            let mut total = 0;
            for i in 0..10{
                let frame = self.frames.get(i);
                if i < 9 {
                    let next_frame = self.frames.get(i + 1);
                    if is_strike(frame.unwrap()) {
                        if next_frame.unwrap().rolls.len() >= 2 {
                            let bonus = next_frame.unwrap().rolls[0..2].to_vec();
                            total += 10 + _sum(&bonus);
                        } else {
                            let bonus = self.frames.get(i + 2).unwrap().rolls.get(0);
                            total += 20 + bonus.unwrap();
                        }
                    } else if is_spare(frame.unwrap()){
                        let bonus = next_frame.unwrap().rolls.get(0);
                        total += 10 + bonus.unwrap();
                    } else {

                        total += _sum(&frame.unwrap().rolls);
                    }
                }else {
                    total += _sum(&frame.unwrap().rolls);
                }
            }
            Some(total)
        } else {
            None
        }
    }
}
