pub fn private_key(_p: u64) -> u64 {
    _p / 2
}

pub fn public_key(_p: u64, _g: u64, _a: u64) -> u64 {
    //(g ** a) mod p
    exp_mod(_g, _a, _p)
}

pub fn secret(_p: u64, _b_pub: u64, _a: u64) -> u64 {
    //(_b_pub ** a) mod p
    exp_mod(_b_pub, _a, _p)
}

pub fn exp_mod(base: u64, _exp: u64, modulus: u64) -> u64 {
    let mut p = 1;
    let mut exp = 0;
    while exp < _exp {
        p *= base;
        exp += 1;
    }
    p % modulus
}
