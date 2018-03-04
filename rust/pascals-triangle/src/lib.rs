pub struct PascalsTriangle {
    rows: u32,
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        PascalsTriangle { rows: row_count }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        match self.rows {
            0 => vec![],
            _ => self.get_rows(),
        }
    }

    pub fn get_rows(&self) -> Vec<Vec<u32>> {
        let mut v = vec![vec![1]];
        for x in 1..self.rows {
            let mut new_row = vec![];
            let a = v.last().unwrap().to_vec();
            let mut b = a.to_vec();
            b.insert(0, 0);
            let mut c = a.to_vec();
            c.push(0);
            for (i, (m, n)) in b.iter().zip(&c).enumerate() {
                new_row.push(m + n);
            }
            v.push(new_row);
        }
        v
    }
}
