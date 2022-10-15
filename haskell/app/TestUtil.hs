module TestUtil where

import qualified Data.List as L
import Test.QuickCheck (quickCheck, Arbitrary(..))
import Test.QuickCheck.Test ( quickCheck )
import Test.QuickCheck.Property ( Testable )


quickcheckWithLabel :: Test.QuickCheck.Property.Testable prop => [Char] -> prop -> IO ()
quickcheckWithLabel str q = do
    putStrLn $ "Testing " <> str <> replicate (40 - length str) '-'
    quickCheck q
    putStrLn $ "DONE    " <> str <> replicate (40 - length str) '-'
