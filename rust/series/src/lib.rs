pub fn series(digits: &str, len: usize) -> Vec<String> {
    let mut v: Vec<String> = vec![];
    let s = String::from(digits);
    if len <= s.len() {
        for x in 0..(s.len() - len + 1) {
            v.push(s[x..(x + len)].to_string());
        }
    }
    v
}
