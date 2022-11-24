(* This is an OCaml editor.
   Enter your program here and send it to the toplevel using the "Eval code"
   button or [Ctrl-e]. *)

let seven_eleven_doubles () =
  let d1 = (Random.int 6) + 1 in
  let d2 = (Random.int 6) + 1 in
  ( (d1 = d2 || d1 + d2 = 7 || d1 + d2 = 11), d1, d2);;

let tris q = match q with
    (_, x, y, z) when x = y && x = z -> true
  | (x, _, y, z) when x = y && x = z -> true
  | (x, y, _, z) when x = y && x = z -> true
  | (x, y, z, _) when x = y && x = z -> true
  | _ -> false;;

type suit = S | H | D | C;;
type card = Card of int * suit;;

let rndSuit () = match (Random.int 4) with
    0 -> S
  | 1 -> H
  | 2 -> D
  | 3 -> C 
  | _ -> failwith "Errore" ;;

let rndCard () = Card ((Random.int 10) + 1, rndSuit ()) ;;

let rndHand () = (rndCard(), rndCard(), rndCard(), rndCard(), rndCard()) ;;

let poker4 (Card (n1,s1), Card (n2,s2), Card (n3,s3), Card(n4,s4)) =
  (n1 = n2 && n2 = n3 && n3 = n4) ;;

let mano = rndHand() ;;

let manoTruccata = ( Card(1, H), Card(1, S), Card(1, D), Card(1, C), Card(5, H))

let poker (c1, c2, c3, c4, c5) = poker4 (c1,c2,c3,c4) || 
                                 poker4 (c2,c3,c4,c5) ||
                                 poker4 (c1,c3,c4,c5) ||
                                 poker4 (c1,c2,c4,c5) ||
                                 poker4 (c1,c2,c3,c5) ;;







































