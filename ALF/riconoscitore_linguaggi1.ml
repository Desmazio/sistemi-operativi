let step k q a =
  assert (q>=0 && q<=k && a>=0 && a<=1);
  if a=1 && q<k then q+1
  else q
;;

let rec lang_rec k q = function
    [] -> q = k
  | a::l -> lang_rec k (step k q a) l
;;

let lang k l = lang_rec k 0 l;;

let step2 (n,b) a =
  if a = 0 && b = 0 then (n+1, b)
  else if a = 1 && b = 0 then (n-1, 1)
  else if a = 1 && b = 1 && n > 0 then (n-1, 1)
  else (-1,-1)

let rec lang_rec2 (n,b) = function
    [] -> n = 0
  | a::l -> lang_rec2 (step2 (n,b) a) l
;;

let lang2 l = lang_rec2 (0,0) l;;