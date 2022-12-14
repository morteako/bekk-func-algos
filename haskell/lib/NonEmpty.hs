module NonEmpty where

import qualified Data.List as L
import Test.QuickCheck (quickCheck, Arbitrary(..))

import Test.QuickCheck.Property ( (===), Property )
import Test.HUnit
    ( assertEqual, runTestTT, Test(TestCase, TestList, TestLabel) )
import TestUtil (quickcheckWithLabel)

data NonEmpty a = a :| [a] deriving (Show,Eq)

-- #prependList
-- Implementer en funksjon som appender en List foran på en NonEmpty List
-- Ex
-- prependList [1,2,3] (4:|[5]) = 1:|[2,3,4,5]
prependList :: [a] -> NonEmpty a -> NonEmpty a
prependList = error "prependList todo"


-- vi kan definere partition ved å gjenbruke partition for vanlige lister
partition :: (a -> Bool) -> NonEmpty a -> ([a], [a])
partition p (x:|xs) = L.partition p (x:xs)

-- gi en NonEmpty Int slik at partitionres = ([1,3],[4,2])
partitionres :: ([Int], [Int])
partitionres = partition odd (error "partitionres todo")

-- #partition 2
-- returtypen til partition ovenfor er lett å bruke, men vi mister litt informasjon
-- hva mangler?
-- hva kan vi vite om de to listene vi får tilbake?
-- hvordan får vi inn denne informasjonen i returtypen?
-- implementer partition' med denne nye typen
-- tips : bruk L.partition p xs for å gjøre grovjobben
-- se også oppgaven under først

type ResType a = () -- TODO

partition' :: (a -> Bool) -> NonEmpty a -> ResType a
partition' = error "partition' todo"

-- #partition 3
-- Vi kan tenke at vi vil gå konverte resultatet fra partion' tilbake til en NonEmpty
-- men bruker vi ([a],[a]) , så klarer vi ikke bedre enn : toNonEmpty :: ([a], [a]) -> Maybe (NonEmpty a)
-- Men som nevnt ovenfor, kan denne typen bli mer presis.
-- Etter du har implementert denne typen, så skal du kunne implementere en  
-- funksjon toNonEmpty' :: ResType a -> NonEmpty a
-- tips : bruk prependList

toNonEmpty :: ([a], [a]) -> Maybe (NonEmpty a)
toNonEmpty (x:xs, ys) = Just $ x :| (xs ++ ys)
toNonEmpty ([], y:ys) = Just $ y :| ys
toNonEmpty ([], []) = Nothing

toNonEmpty' :: ResType a -> NonEmpty a
toNonEmpty' = error "toNonEmpty' todo"

----------------------
---TESTS

toList :: NonEmpty a -> [a]
toList (a :| as) = a : as

instance Arbitrary a => Arbitrary (NonEmpty a) where
    arbitrary = (:|) <$> arbitrary <*> arbitrary

testPartitionRes = TestList [TestLabel "partionres" $ TestCase (assertEqual "partionres" ([1, 3], [4, 2]) partitionres)]


prop_prepend :: [Int] -> NonEmpty Int -> Property  
prop_prepend xs ys = toList (prependList xs ys) === (xs ++ toList ys)

prop_partition' :: NonEmpty Int -> Property
prop_partition' xs = lp === Just np 
    where
        lp = toNonEmpty $ partition even xs
        np = toNonEmpty' $ partition' even xs




main :: IO ()
main = do
    quickcheckWithLabel "prep_prepend" prop_prepend
    runTestTT testPartitionRes
    quickcheckWithLabel "prop_partition'" prop_partition'
