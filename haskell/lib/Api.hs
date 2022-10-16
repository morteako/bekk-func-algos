module Api where

import qualified Data.Map.Strict as Map
import qualified Data.Set as Set
import Test.HUnit

-- bare en helper for å lage tupler
(#>) :: a -> b -> (a, b)
(#>) = (,)

maps :: [Map.Map String Int]
maps =
    [ Map.fromList ["morten" #> 300]
    , Map.fromList ["kim" #> 400]
    , Map.fromList ["morten" #> 100, "kim" #> 50]
    , Map.fromList ["lars" #> 100]
    ]

-- Bruk unionWith eller unionWithMut til å kombinere mapsa i listen ovenfor.
-- altså summere valuene
-- Bruk gjerne reduce/fold
combinedMaps :: Map.Map String Int
combinedMaps = error "combinedMaps todo"

-- Bruk intersectionWith til å kombinere imap1 og imap2
-- Her skal du samle opp alle tallene(verdiene i mapsene) i lista for keysene som finnes i begge maps
-- Se test for forventet resultat
imap1 :: Map.Map String Int
imap1 = Map.fromList ["morten" #> 300, "lars" #> 200]

imap2 :: Map.Map String Int
imap2 =
    Map.fromList ["morten" #> 100, "kim" #> 50]

intersectedMaps :: Map.Map String [Int]
intersectedMaps =
    error "intersectedMaps todo"

-------------------------
-- Algebraiske egenskaper

-- Hva er identitetselementet til union og unionWith?
-- dvs, hvilket map `m` gir Map.union m m2 = m2 og Map.union m2 m = m2
-- uansett verdi til m2 ?
-- (gjelder også for Map.unionWith f)

-- Er union kommutativ?
-- dvs, for to maps m og m2, er alltid Map.union m m2 == Map.union m2 m?

-- Er unionWith kommutativ?
-- dvs, for to maps m og m2 og funksjon f, er alltid Map.unionWith f m m2 == Map.unionWith f m2 m?

-- Er union og unionWith assosiative?
-- dvs, for maps m, m2, m3, er alltid Map.union m (Map.union m2 m3) == Map.union (Map.union m m2) m3
-- (gjelder også for Map.unionWith f)

-- Har intersection og intersectionWith et absorberende element?
-- dvs, finnes det et map `m` som gir Map.intersection m m2 = m og Map.intersection m2 m = m
-- uansett verdi til m2 ?

-- Er union idempotent?
-- dvs, er Map.union m m == m, alltid sant?

-- Er intersection idempotent?
-- dvs, er Map.intersection m m == m, alltid sant?

---------------------------------
-- TESTS
combinedMapsTest :: Test
combinedMapsTest = TestList [TestLabel "combinedMaps" $ TestCase (assertEqual "combinedMaps" combinedMaps expected)]
  where
    expected = Map.fromList [("kim", 450), ("lars", 100), ("morten", 400)]

intersectedMapsTest :: Test
intersectedMapsTest = TestList [TestLabel "intersectedMaps" $ TestCase (assertEqual "intersectedMaps" intersectedMaps expected)]
  where
    expected = Map.fromList ["morten" #> [300, 100]]

main :: IO ()
main = do
    runTestTT combinedMapsTest
    runTestTT intersectedMapsTest
    pure ()
