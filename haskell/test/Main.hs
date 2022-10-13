module Main where


import Test.QuickCheck

prop_reverse :: [Int] -> Bool
prop_reverse xs = reverse xs == xs

main :: IO ()
main = do
    quickCheck prop_reverse
    return ()
    