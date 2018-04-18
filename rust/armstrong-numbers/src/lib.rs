pub fn is_armstrong_number(num: u32) -> bool {
    let digits_string = num.to_string();
    let n = digits_string.chars().count();
    let pow_sum = digits_string
        .chars()
        .map(|d| d.to_digit(10).unwrap())
        .map(|r| r.pow(n as u32))
        .fold(0, |sum, x| sum + x);
    num == pow_sum
}
