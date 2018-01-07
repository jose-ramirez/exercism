fn transform(i:usize, c:char) -> usize{
    let mut res = (c.to_string()).parse::<usize>().unwrap();
    if i % 2 == 1 {
        res = 2 * res;
        if res > 9 {
            res = res - 9;
        }
    } res
}

fn check(s: &str, l: Vec<&str>) -> bool {
    for ch in l {
        if s.contains(ch) {
            return true;
        }
    } false
}

fn my_sum(list: Vec<usize>) -> usize {
    let mut total = 0;
    for number in list {
        total += number;
    } total
}

pub fn is_valid(code: &str) -> bool {

    if check(code, vec!["a", "-", "£", "$"]) {
        return false;
    }

    if code.trim().len() == 1 {
        return false;
    }

    let transformed_code: Vec<usize> = code
        .trim()
        .replace(" ", "")
        .chars()
        .rev()
        .enumerate()
        .map(|(i, c)| transform(i, c))
        .collect();

    my_sum(transformed_code) % 10 == 0
}