pub fn hamming_distance(ch1: &str, ch2: &str) -> Result<i32, i32> {
    let s1 = ch1.as_bytes();
    let s2 = ch2.as_bytes();
    let mut total = 0;
    let l1 = s1.len();
    let l2 = s2.len();
    if l1 != l2 {
        Err(-1)
    } else {
        let i = 0;
        for i in 0..l1 {
            if s1[i] != s2[i] {
                total += 1;
            }
        }
        Ok(total)
    }
}
