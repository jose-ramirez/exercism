#[allow(unused_variables)]

use std::collections::HashMap;

#[derive(Default)]
pub struct School {
    pub grades: HashMap<u32, Vec<String>>,
}

impl School {
    pub fn new() -> School {
        School::default()
    }

    pub fn add(&mut self, grade: u32, student: &str) {
        let entry = self.grades.entry(grade).or_insert(vec![]);
        entry.push(student.to_owned());
        entry.sort();
    }

    pub fn grades(&self) -> Vec<u32> {
        let mut grades:Vec<u32> = self.grades.keys().cloned().collect();
        grades.sort();
        grades
    }

    // If grade returned an `Option<&Vec<String>>`,
    // the internal implementation would be forced to keep a `Vec<String>` to lend out.
    // By returning an owned vector instead,
    // the internal implementation is free to use whatever it chooses.
    pub fn grade(&self, grade: u32) -> Option<Vec<String>> {
        self.grades.get(&grade).cloned()
    }
}
