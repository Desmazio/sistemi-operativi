(* This is an OCaml editor.
   Enter your program here and send it to the toplevel using the "Eval code"
   button or [Ctrl-e]. *)

let rec f n = match n with
    0 -> 0
  | m when m > 0 -> let y = f (m - 1) in y + 2
  | _ -> failwith "f indefinita sui numeri negativi"
;;

let rec f1 = function
    0 -> 0
  | 1 -> -1
  | n when n > 0 -> let b = f1 (n - 2) in 
      if b < 0 then b - 1 else b + 1
  | _ -> failwith "errore"
;;

let rec fact = function
    0 -> 1
  | n when n > 0 -> n * fact (n - 1)
  | _ -> failwith "n dev'essere positiva"
;;

type nat = Z | S of nat;;

let rec double = function
    Z -> Z
  | S a -> S (S (double a))
;;

let rec add a b = match a with
    Z -> b
  | S a' -> let n = add a' b in S n
;;
  