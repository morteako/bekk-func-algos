module List where

import Prelude hiding (reverse)
import Test.QuickCheck ( (===), Property )
import qualified Data.List as L
import TestUtil ( quickcheckWithLabel )



-- #Rev 1
--skriv en funksjon som reverserer en liste ved å ++ elementer bakerst
reverse :: [a] -> [a]
reverse = error "TODO reverse"

-- #Rev 2
-- Hva er suboptimalt med løsningen over?
-- Hva er kjøretidskompleksiteten?
-- Hva burde vi forvente den er?

-- #Rev 3
-- Skriv reverse på nytt, men en mer optimal versjon
-- Hint : lag enda en funksjon (gjerne internt i reverse')
reverse' :: [a] -> [a]
reverse' = error "TODO reverse"

---------

prop_reverse :: [Int] -> Property
prop_reverse xs = L.reverse xs === reverse xs

prop_reverse' :: [Int] -> Property
prop_reverse' xs = L.reverse xs === reverse' xs


main :: IO ()
main = do
    quickcheckWithLabel "prop_reverse" prop_reverse
    quickcheckWithLabel "prop_reverse'" prop_reverse'
