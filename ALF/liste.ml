let rec rnd_list n b =
  if(n <= 0) then []
  else (Random.int b) :: (rnd_list (n - 1) b);;

let rec rev l1 = match l1 with
    [] -> []
  | hd :: tl -> (rev tl) @ [hd];;

let lista = [1;2;3;4;5];;

let rec string_of_listRec l = match l with
    [] -> "]"
  | hd1::[] -> (string_of_int hd1) ^ "]"
  | hd::tl -> (string_of_int hd) ^ ";" ^ string_of_listRec tl
;;

let string_of_list l =
  "[" ^ (string_of_listRec l);;

let rec mem el l = match l with
    [] -> false
  | hd::tl -> if (hd = el) then true else (mem el tl)
;;

let rec dup l = match l with
    [] -> false
  | hd::tl -> (mem hd tl) || (dup tl)
;;

let rec mkset l = match l with
    [] -> []
  | hd::tl -> if (mem hd tl) then mkset tl else hd :: (mkset tl)
;;

let rec union l1 l2 = match l1 with
    [] -> l2
  | hd::tl -> if (mem hd l2) then union tl l2 else hd :: (union tl l2)
;;