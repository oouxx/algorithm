#include <Struct.h>
class Solution
{
public:
    TreeNode *ans;
    bool dfs(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == nullptr)
            return false;
        bool lson = dfs(root->left, p, q);
        bool rson = dfs(root->right, p, q);
        // 公共祖先应满足的条件
        /*
        1. 条件一 (lson && rson) 说明左子树和右子树均包含p节点或q节点
        2. 条件二 (root->val == p->val) && (lson || rson) 说明root节点刚好是p节点或q节点,此时q节点或q节点包含在左子树或者右子树内
        因为dfs就是自底向上更新的,所以找到的一定是最近的公共祖先
        */
        // (lson && rson) || ((root->val == p->val || root->val == q->val) && (lson || rson))

        if ((lson && rson) || ((root->val == p->val || root->val == q->val) && (lson || rson)))
        {
            ans = root;
        }
        return lson || rson || (root->val == p->val || root->val == q->val);
    }
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        dfs(root, p, q);
        return ans;
    }
};