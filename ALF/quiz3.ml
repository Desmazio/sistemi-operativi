let rec a = function
    0 -> 0
  | n -> 1 + b(n - 1)
and b = function
    0-> 1
  | n -> 2 + a(n - 1)
;;

let rec count x = function   (* conta di x nella lista *)
    [] -> 0;
  | y::l -> (if x = y then 1 else 0) + count x l
;;

let rec lang = function
    [] -> true
  | 1::l -> (count 0 l = count 2 l) && lang l
  | x::l when x = 0 || x = 2 -> lang l
  | _ -> false
;;

let only2 l = List.filter ( fun x -> x <> 2 ) l ;;

let rec halve_rec n l = 
  if n=0 then ([],l)
  else match l with 
      [] -> failwith "err" 
    | x::l' -> let (l1,l2) = halve_rec (n-1) l' in (x::l1,l2)
;;

let halve l = halve_rec ((List.length l) / 2) l;;

let lang l = 
  let l' = only2 l in
  let (l1,l2) = halve l' in 
  List.length l1 = List.length l2 &&
  count 0 l1 = List.length l1 &&
  count 1 l2 = List.length l2
;;