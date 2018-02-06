// return Ok(x) where x is the number of steps required to reach 1
pub fn collatz(n: u64) -> Result<u64, &'static str> {
    let mut total = 0;
    let mut x = n;
    if n == 0 {
        return Err("");
    }
    while x != 1 {
        if x % 2 == 0 {
            x = x / 2
        } else {
            x = 3 * x + 1
        }
        total += 1
    }
    Ok(total)
}
