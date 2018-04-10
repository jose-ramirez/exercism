// The code below is a stub. Just enough to satisfy the compiler.
// In order to pass the tests you can add-to or change any of this code.

#[derive(PartialEq, Debug)]
pub enum Direction {
    North,
    East,
    South,
    West,
}

pub struct Robot{
    direction: Direction,
    position: (isize, isize)
}

impl Robot {
    pub fn new(x: isize, y: isize, d: Direction) -> Self {
        Robot {
            direction: d,
            position: (x, y)
        }
    }

    pub fn turn_right(self) -> Self {
        match self.direction {
            Direction::North => Robot {position: self.position, direction: Direction::East},
            Direction::East => Robot {position: self.position, direction: Direction::South},
            Direction::West => Robot {position: self.position, direction: Direction::North},
            Direction::South => Robot {position: self.position, direction: Direction::West},
        }
    }

    pub fn turn_left(self) -> Self {
        match self.direction {
            Direction::North => Robot {position: self.position, direction: Direction::West},
            Direction::East => Robot {position: self.position, direction: Direction::North},
            Direction::West => Robot {position: self.position, direction: Direction::South},
            Direction::South => Robot {position: self.position, direction: Direction::East},
        }
    }

    pub fn advance(self) -> Self {
        let (x, y) = self.position;
        match self.direction {
            Direction::North => Robot {position: (x, y + 1), direction: self.direction},
            Direction::East => Robot {position: (x + 1, y), direction: self.direction},
            Direction::West => Robot {position: (x - 1, y), direction: self.direction},
            Direction::South => Robot {position: (x, y - 1),direction:  self.direction},
        }
        
    }

    pub fn instructions(self, instructions: &str) -> Self {
        let mut r: Robot = self;
        for instruction in instructions.chars() {
            match instruction {
                'L' => r = r.turn_left(),
                'A' => r = r.advance(),
                'R' => r = r.turn_right(),
                _ => r = r
            }
        }
        r
    }

    pub fn position(&self) -> (isize, isize) {
        self.position
    }

    pub fn direction(&self) -> &Direction {
        &self.direction
    }
}
