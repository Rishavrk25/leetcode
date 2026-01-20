class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}
        n = len(nums)
        for i in range(n):
            rem = target-nums[i]
            if rem in mp:
                return [mp[rem],i]
            mp[nums[i]]=i
        