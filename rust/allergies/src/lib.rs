pub struct Allergies {
    val: u32
}

#[derive(Debug, PartialEq, Clone)]
pub enum Allergen {
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats,
}

impl Allergies {
    pub fn new(score: u32) -> Self {
        Allergies { val: score }
    }

    pub fn is_allergic_to(&self, allergen: &Allergen) -> bool {
        self.allergen_score(allergen) <= self.val 
    }

    pub fn allergies(&self) -> Vec<Allergen> {
        let mut allergies_vector = vec![];
        let allergies_as_vector = self.allergen_vector();
        let corrected_score = self.val % 256;
        let score_as_binary_str = format!("{:0>8b}", corrected_score);
        for (i, c) in score_as_binary_str.chars().rev().enumerate() {
            if c == '1' {
                allergies_vector.push(allergies_as_vector[i].clone());
            }
        }
        allergies_vector
    }
    
    pub fn allergen_score(&self, allergen: &Allergen) -> u32 {
        match allergen {
            Allergen::Eggs => 1,
            Allergen::Peanuts => 2,
            Allergen::Shellfish => 4,
            Allergen::Strawberries => 8,
            Allergen::Tomatoes => 16,
            Allergen::Chocolate => 32,
            Allergen::Pollen => 64,
            Allergen::Cats => 128
        }
    }

    pub fn allergen_vector(&self) -> Vec<Allergen> {
        vec![Allergen::Eggs, Allergen::Peanuts, Allergen::Shellfish, Allergen::Strawberries, Allergen::Tomatoes, Allergen::Chocolate, Allergen::Pollen, Allergen::Cats]
    }
}
