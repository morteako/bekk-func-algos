# Funksjonelle algoritmer

# Disclaimer

# Relevante prinsipper i funksjonell programmering
* Pure functions og da ingen mutering
* Korrekthet, presis
* Higher order functions
* Matematiske abstraksjoner

# Problemer med vanlige datastrukturer i en funksjonell setting

* Performance - kopiering
* Kotlin std-lib eksempel



# Hva er galt 
* 


## Vanlig algoritmer / datastrukturer
* Mutasjon
  ArrayList.add
* Arrays


## Persistant data structures
* Sharing


## Lister

[] | a : [a]
 
class Nil : List
data class Cons(head:Int, tail:List)

## Snoc

## Begge veier?

## Appending

## DiffList?



## Trær
* Veldig mye er trebasert
  * Algebraiske datatyper er jo bare trær
* Men ofte litt vanskeligere enn vi har tid til her

## API

* map / fmap
* Fold / reduce - Foldable
* union, difference, - with, With

## Ligninger. Generelle egenskaper. Kanskje

* Kjekt for testing (property testing)
* reverse (reverse liste) = liste
* not (not b) = b
* elem b (insert b m) = True

## Verifiserte datastrukturer
* Parse, don't validate
* Illegal states irepresentable


## NonEmptyList


* a :| [a]
  * Group


## Funksjoner

* Head
* Tail
* append
* foldr1 / reduce Kotlin som er safe!
* filter
  
* Maybe (NonEmpty a) ~ [a]

# Konklusjon / Oppsummering

## Oppgaver

### API

union
unionWith / diff / intersec


### Sharing

### Lister

### NonEmpty
partition :: (a -> Bool) -> NonEmpty a -> ([a], [a])
partition :: (a -> Bool) -> NonEmpty a -> Either (NonEmpty a,[a]) ([a],NonEmpty [a])
partition :: (a -> Bool) -> NonEmpty a -> ([a],a,[a])

toNonEmpty :: PresisType -> NonEmpty a
og
for alle p og alle xs : toNonEmpty (partition p xs) = xs
toNonEmpty . partition p = id

groupBy :: (a -> a -> Bool) -> [a] -> [NonEmpty a]
groupBy :: (a -> a -> Bool) -> NonEmpty a -> TODO

## Ekstra lesning 
Okasaki
