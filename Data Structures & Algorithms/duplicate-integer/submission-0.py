class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nodupli=set()
        for x in nums:
            if x in nodupli:
                return "true"
            nodupli.add(x)
        return "false"