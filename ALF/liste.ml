let rec for_all p = function
    [] -> true
  | h::l -> (p h) && for_all p l
;;

for_all (fun x-> x mod 2 = 0) [4;2;8;];; 

(* for_all è già inclusa su OCaml *) 
List.for_all (fun x -> x mod 2 = 0) [4;2;8;];;

let rec map p = function
    [] -> []
  | h::l -> p h :: map p l
;;

map (fun x -> x * 2) [2;4;6];;

(* map è già inclusa su OCaml *)
List.map (fun x -> x * 2) [2;4;6];;

let rec filter p = function
    [] -> []
  | h::l -> if p h then h::(filter p l) else filter p l
;;

filter (fun x -> x mod 2 = 0) [1;2;3;4;5;6];;

(* filter è già inclusa su OCaml *)
List.filter (fun x -> x mod 2 = 0) [1;2;3;4;5;6];;

let rec addlist = function
    [] -> 0
  | h::l -> h + addlist l
;;

addlist [1;2;3;4];;

let rec fold_left f z = function
    [] -> z
  | h::l -> fold_left f (f z h) l
;;

fold_left (-) 0 [3;2];;

let rec mem x = function
    [] -> false
  | y::l -> if x = y then true else mem x l
;; 

let maxL l = fold_left 
    (fun r x -> match r with 
         None -> Some x
       | Some y -> if y > x then Some y else Some x)
    None l;;

maxL [1;4;5;3;7;2;4];;

let len l = fold_left (fun r x -> r + 1) 0 l;; 

len [1;4;6;3;4];;

let for_all2 p l = fold_left (fun r x -> r && p x) true l;;

for_all2 (fun x-> x mod 2 = 0) [4;2;8;];; 
