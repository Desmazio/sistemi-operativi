type nat = Z | S of nat;;

let zero = Z;;
let uno  = S Z;;
let due  = S (S Z);;
let tre = S(S(S Z));;
let quattro = S(S(S(S Z)));;
let cinque = S(S(S(S(S Z))));;
let dieci = S(S(S(S(S(S(S(S(S(S Z)))))))));;

let rec add n1 n2 = match (n1, n2) with 
    (n1, Z) -> n1
  | (n1, S e2) -> add (S n1) e2
;;

let rec mul n1 n2 = match (n1, n2) with
    (Z, n2) -> Z
  | (S Z, n2) -> n2
  | (S e1, n2) -> add (mul e1 n2) n2
;; 

let equals n1 n2 = if (n1 = n2) then true else false;;

let rec equals2 n1 n2 = match (n1, n2) with
    Z, Z -> true
  | _, Z -> false
  | Z, _ -> false
  | S e1, S e2 -> equals2 e1 e2
;;

let leq n1 n2 = if (n1 <= n2) then true else false;;

let rec leq2 n1 n2 = match (n1, n2) with
    Z, _ -> true
  | _, Z -> false 
  | S e1, S e2 -> leq2 e1 e2
;; 