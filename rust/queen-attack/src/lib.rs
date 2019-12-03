#[derive(Debug)]
pub struct ChessPosition{
    rank: i32,
    file: i32
}

#[derive(Debug)]
pub struct Queen{
    rank: i32,
    file: i32
}

impl ChessPosition {
    pub fn new(rank: i32, file: i32) -> Option<Self> {
        match 0 <= rank && rank < 8 && 0 <= file && file < 8 {
            true => Some(ChessPosition {rank: rank, file: file}),
            false => None
        }
    }
}

impl Queen {
    pub fn new(position: ChessPosition) -> Self {
        Queen{
            rank: position.rank,
            file: position.file
        }
    }

    pub fn can_attack(&self, other: &Queen) -> bool {
        let d_rank = self.rank - other.rank;
        let d_file = self.file - other.file;
        let same_diagonal = self.rank + self.file == other.rank + other.file;
        return d_rank == 0 || d_file == 0 || d_rank == d_file || d_rank + d_file == 0 || same_diagonal
    }
}
