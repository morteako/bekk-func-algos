module NonEmpty where
-- import List
import qualified Data.List as L

data NonEmpty a = a :| [a] deriving Show

partition :: (a -> Bool) -> NonEmpty a -> ([a], [a])
partition p (x:|xs) = L.partition p (x:xs)
-- partition :: (a -> Bool) -> NonEmpty a -> Either (NonEmpty a, [a]) ([a], NonEmpty [a])
-- partition :: (a -> Bool) -> NonEmpty a -> ([a], a, [a])


toNonEmpty :: ([a], [a]) -> Maybe (NonEmpty a)
toNonEmpty (x:xs, ys) = Just $ x :| (xs ++ ys)
toNonEmpty ([], y:ys) = Just $ y :| ys
toNonEmpty ([], []) = Nothing

f p = toNonEmpty . partition p


main :: IO ()
main = do
    print $ 1
