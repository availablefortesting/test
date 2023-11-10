class Solution:
    def countHomogenous(self, s: str) -> int:
        s = list(s)
        s.append('*')   # to get last counts
        
        prev_c = s[0]
        cur_cnt = 1
        res, mod = 0, 10**9 + 7
        
        for r in range(1, len(s)):
            if s[r] == prev_c:
                cur_cnt += 1
            else:
                res = (res + (cur_cnt * (cur_cnt + 1)) // 2) % mod
                prev_c = s[r]
                cur_cnt = 1
                
        return res
        