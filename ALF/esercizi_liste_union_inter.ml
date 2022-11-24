let rec extract i l = match l with 
    [] -> failwith "Index out of bound"
  | hd::tl -> if(i = 0) then (hd, tl)
      else
        let (a, b) = extract (i - 1) tl
        in (a, hd::b)
;;

let mem el l =   (* restituisce true se el appartiene alla lista l *)
  List.fold_left ( fun a b -> if b = el then true else a) false l;;

let mkset l =    (* elimina i doppioni *)
  List.fold_left ( fun a b -> if mem b a then a else a @ [b] ) [] l;; 

let dup l =      (* restituisce true se nella lista l è presente un doppione *) 
  not ( List.length l = List.length (mkset l));;   (* Se la lunghezza normale è uguale a quella dopo mkset, che
                                                      rimuove i doppioni, allora non ci sono doppioni *)
  
let union l1 l2 =   (* restituisce tutti gli elementi di l1 e l2 presi una sola volta (assumiamo assenza di duplicati *)
  mkset (l1@l2);;   (* senza fold *)
  
let union2 l1 l2 =  (* con fold *)
  List.fold_left ( fun a b -> if mem b a then a else a @ [b]) l1 l2;;

let inter l1 l2 =   (* restituisce gli elementi che sono sia in l1 che in l2 *) (* con fold *)
  List.fold_left ( fun a b -> if mem b l2 then a@[b] else a ) [] l1;;
  
let inter2 l1 l2 =  (* con filter *)
  List.filter ( fun x -> mem x l2 ) l1;;

let diff l1 l2 =   (* restituisce i valori di l1 che non sono in l2 *) 
  List.fold_left ( fun a b -> if not(mem b l2) then a@[b] else a ) [] l1;;   

(* restituisce un insieme dove ogni elemento viene trasformato in una coppia (i, el),
   dove i indica l'insieme di appartenenza *)
let dsum l1 l2 =   
  List.map ( fun x -> (0, x) ) l1 @
  List.map ( fun x -> (1, x) ) l2;;