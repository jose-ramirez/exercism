pub fn find(v: &[usize], value: usize) -> Option<usize>{
    if v.len() == 0 {
        return None;
    }

    let mut lo = 0;
    let mut hi = v.len() - 1;
    let min_value: usize = v.into_iter().fold(255, |a, b| if a < *b {a} else {*b});

    if value < min_value {
        return None;
    }

    while lo <= hi {
        let mid = (lo + hi) / 2;
        if v[mid] < value {
           lo = mid + 1; 
        } else if v[mid] > value {
            hi = mid - 1;
        } else {
            return Some(mid);
        }
    }

    return None;
}