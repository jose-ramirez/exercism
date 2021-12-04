// This stub file contains items which aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

pub fn production_rate_per_hour(speed: u8) -> f64 {
    speed as f64 * 221 as f64 * get_success_rate(speed)
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    production_rate_per_hour(speed) as u32 / 60
}

fn get_success_rate(speed: u8) -> f64 {
    return if speed < 1 || speed > 10 {
        0.0
    } else if speed < 5 {
        1.0
    } else if speed < 9 {
        0.9
    } else {
        0.77
    }
}