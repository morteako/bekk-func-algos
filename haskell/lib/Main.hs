module Main where
import qualified List
import qualified NonEmpty
import qualified Api


main :: IO ()
main = do
    List.main
    NonEmpty.main
    Api.main
