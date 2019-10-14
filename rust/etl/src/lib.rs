use std::collections::BTreeMap;

pub fn transform(h: &BTreeMap<i32, Vec<char>>) -> BTreeMap<char, i32> {
    let mut res: BTreeMap<char, i32> = BTreeMap::new();
    for (k, v) in h {
        for c in v {
            res.insert(convert_char(*c), *k);
        }
    }
    return res;
}

fn convert_char(c: char) -> char {
    c.to_lowercase().collect::<Vec<_>>()[0]
}
