#[derive(Default)]
pub struct SimpleLinkedList<T> {
    pub nodes: Vec<T>,
}

impl<T> SimpleLinkedList<T> {
    pub fn new() -> Self {
        Self { nodes: vec![] }
    }

    pub fn len(&self) -> usize {
        self.nodes.len()
    }

    pub fn push(&mut self, element: T) {
        self.nodes.push(element)
    }

    pub fn pop(&mut self) -> Option<T> {
        self.nodes.pop()
    }

    pub fn peek(&self) -> Option<&T> {
        self.nodes.last()
    }
}

impl<T: Clone> SimpleLinkedList<T> {
    pub fn rev(&self) -> SimpleLinkedList<T> {
        let mut s = SimpleLinkedList::<T>::new();
        for n in &self.nodes {
            s.nodes.insert(0, n.clone());
        }
        s
    }
}

impl<'a, T: Clone> From<&'a [T]> for SimpleLinkedList<T> {
    fn from(item: &[T]) -> Self {
        let mut s = SimpleLinkedList::<T>::new();
        for i in item {
            s.push(i.clone());
        }
        s
    }
}

impl<T> Into<Vec<T>> for SimpleLinkedList<T> {
    fn into(mut self) -> Vec<T> {
        self.nodes
    }
}
