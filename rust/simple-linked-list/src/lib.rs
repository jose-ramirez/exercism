pub struct SimpleLinkedList<T> {
    head: Option<Box<Node<T>>>,
}

struct Node<T> {
    value: T,
    next: Option<Box<Node<T>>>,
}

impl<T> SimpleLinkedList<T> {
    pub fn new() -> Self {
        SimpleLinkedList { head: None }
    }

    pub fn len(&self) -> usize {
        let mut total = 0;
        let mut h = &self.head;
        loop {
            match *h {
                None => break,
                Some(ref v) => h = &v.next,
            };
            total += 1;
        }
        total
    }

    pub fn push(&mut self, element: T) {
        self.head = Some(Box::new(Node {
            value: element,
            next: self.head.take(),
        }))
    }

    pub fn pop(&mut self) -> Option<T> {
        match self.head.take() {
            None => None,
            Some(mut val) => {
                self.head = val.next.take();
                Some(val.value)
            }
        }
    }

    pub fn peek(&self) -> Option<&T> {
        match self.head {
            None => None,
            Some(ref node) => Some(&node.value),
        }
    }
}

impl<T: Clone> SimpleLinkedList<T> {
    pub fn rev(&self) -> SimpleLinkedList<T> {
        let mut list = SimpleLinkedList::new();
        let mut head = &self.head;
        while let &Some(ref node) = head {
            list.push(node.value.clone());
            head = &node.next;
        }
        list
    }
}

impl<'a, T: Clone> From<&'a [T]> for SimpleLinkedList<T> {
    fn from(item: &[T]) -> Self {
        let mut l = SimpleLinkedList::new();
        item.iter().for_each(|x| l.push(x.clone()));
        l
    }
}

impl<T> Into<Vec<T>> for SimpleLinkedList<T> {
    fn into(mut self) -> Vec<T> {
        let mut v = Vec::new();
        while let Some(n) = self.pop() {
            v.push(n);
        }
        v.reverse();
        v
    }
}
