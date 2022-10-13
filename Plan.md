# Funksjonelle algoritmer

# Disclaimer

# Relevante prinsipper i funksjonell programmering
* Pure functions og da ingen mutering
* Korrekthet
* Higher order functions
* Matematiske abstraksjoner

# Problemer Kotlin

* Performance - kopiering



# Hva er galt 


## Vanlig algoritmer / datastrukturer
* Muturer
  ArrayList.add


## Persistant data structures
* Sharing




## Lister


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

## Ligninger. Generelle eggenskaper

* Kjekt for testing (property testing)


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
