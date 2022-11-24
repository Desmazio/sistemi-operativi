type bitstring = E | Z of bitstring | U of bitstring;;

(* otto = 1000 in binario *)
let otto = U(Z(Z(Z(E))));;
let quattro = U(Z(Z(E)));;
let cinque = U(Z(U(E)));;

let rec string_of_bitstring b = match b with
    E -> ""
  | Z b1 -> "0" ^ string_of_bitstring b1
  | U b1 -> "1" ^ string_of_bitstring b1
;;

let rec len b = match b with
    E -> 0
  | Z b1 -> 1 + len b1
  | U b1 -> 1 + len b1
;;

(* string -> string -> string *)
let concat a b = string_of_bitstring a ^ string_of_bitstring b;;

(* bitstring -> bitstring -> bitstring *)
let rec concat2 a b = match (a, b) with
    E, b -> b
  | (U a1, b) -> U (concat2 a1 b)
  | (Z a1, b) -> Z (concat2 a1 b)
;;