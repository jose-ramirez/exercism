pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    let mut res: Vec<(usize, usize)> = Vec::<(usize, usize)>::new();
    let rows = input.len();
    let columns = input[0].len();
    for i in 0..rows {
        for j in 0..columns {
            let el = input[i][j];
            let mut c = column(j, input);
            if el == vector_max(&input[i]) && el == vector_min(c) {
                res.push((i, j));
            }
        }
    }
    res
}

pub fn vector_min(input: Vec<u64>) -> u64 {
    let mut min = 1000u64;
    for x in input {
        if min > x {
            min = x;
        }
    }
    min
}

pub fn vector_max(input: &Vec<u64>) -> u64 {
    let mut max = 0u64;
    for x in input {
        if max < *x {
            max = *x;
        }
    }
    max
}

pub fn column(index: usize, input: &[Vec<u64>]) -> Vec<u64> {
    let mut col = vec![];
    for row in input {
        col.push(row[index]);
    }
    col
}
