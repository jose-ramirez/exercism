use std::collections::HashSet;

pub fn brackets_are_balanced(string: &str) -> bool {
    let mut valid_char_set = HashSet::new();
    valid_char_set.insert('{');
    valid_char_set.insert('}');
    valid_char_set.insert('[');
    valid_char_set.insert(']');
    valid_char_set.insert('(');
    valid_char_set.insert(')');

    if string == "" {
        return true;
    }
    let mut stack: Vec<char> = vec![];
    for c in string.chars() {
        if !valid_char_set.contains(&c) {
            continue;
        }
        stack.push(c);
        let length = stack.len();
        if stack.len() > 1 {
            if matched(stack[length - 1], stack[length - 2]) {
                stack.pop();
                stack.pop();
            }
        }
    }
    return stack.len() == 0;
}

pub fn matched(char1: char, char2: char) -> bool {
    (char1 == ']' && char2 == '[')
        || (char1 == '}' && char2 == '{')
        || (char1 == ')' && char2 == '(')
}
