use std::convert::From;

pub struct Luhn{
    value: String,
}

impl<'a> From<&'a str> for Luhn {
    fn from(item: &'a str) -> Self {
        Luhn {value: item.to_owned()}
    }
}

impl From <u8> for Luhn{
    fn from(item: u8) -> Self {
        Luhn {value: item.to_string()}
    }
}

impl From <u16> for Luhn{
    fn from(item: u16) -> Self {
        Luhn {value: item.to_string()}
    }
}

impl From <u32> for Luhn{
    fn from(item: u32) -> Self {
        Luhn {value: item.to_string()}
    }
}

impl From <u64> for Luhn{
    fn from(item: u64) -> Self {
        Luhn {value: item.to_string()}
    }
}

impl From <usize> for Luhn{
    fn from(item: usize) -> Self {
        Luhn {value: item.to_string()}
    }
}

impl From<String> for Luhn {
    fn from(item: String) -> Self {
        Luhn {value: item}
    }
}

impl Luhn {
    pub fn transform(&self, i:usize, c:char) -> usize{
        let mut res = (c.to_string()).parse::<usize>().unwrap();
        if i % 2 == 1 {
            res = 2 * res;
            if res > 9 {
                res = res - 9;
            }
        } res
    }

    pub fn check(&self, s: &str, l: Vec<&str>) -> bool {
        for ch in l {
            if s.contains(ch) {
                return true;
            }
        } false
    }

    pub fn my_sum(&self, list: Vec<usize>) -> usize {
        let mut total = 0;
        for number in list {
            total += number;
        } total
    }

    pub fn is_valid(&self) -> bool {

        if self.check(&self.value, vec!["a", "-", "£", "$"]) {
            return false;
        }

        if self.value.trim().len() == 1 {
            return false;
        }

        let transformed_code: Vec<usize> = self.value
            .trim()
            .replace(" ", "")
            .chars()
            .rev()
            .enumerate()
            .map(|(i, c)| self.transform(i, c))
            .collect();

        self.my_sum(transformed_code) % 10 == 0
    }
}
