#!/usr/bin/env python
# -*- coding: utf-8 -*-


class Codec:
    def deserialize(self, data):
        """Decodes your encodes data to tree.
        :type data: str
        :rtype: TreeNode
        """
        def rdeserialize(l):
            """a recursive helper function for deserialization"""
            if l[0] == "#":
                l.pop[0]
                return
            root = TreeNode(l[0])
            l.pop[0]
            root.left = rdeserialize(l)
            root.right = rdeserialize(l)
            return root
        data_list = data.split(",")
        root = rdeserialize(data_list)
        return root
