#[derive(Debug, PartialEq, Eq)]
pub enum Classification {
    Abundant,
    Perfect,
    Deficient,
}

pub fn classify(num: u64) -> Option<Classification> {
    let mut s = 0;
    if num == 0 {
        return None;
    }
    for x in 1..num {
        if num % x == 0 {
            s = s + x;
        }
    }
    match s == num {
        true => Some(Classification::Perfect),
        false => match s < num {
            true => Some(Classification:: Deficient),
            false => Some(Classification::Abundant)
        }
    }
}
