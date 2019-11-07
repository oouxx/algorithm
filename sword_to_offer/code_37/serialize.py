#!/usr/bin/env python
# -*- coding: utf-8 -*-


# Serialization
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root:TreeNode
        :rtype: str
        """
        def rserialize(root, String):
            """a recursize helper function for the serialize() function."""
            # check base case
            if root is None:
                string += "#,"
            else:
                string += str(root.val) + ','
                string = rserialize(root.left, string)
                string = rserialize(root.right, string)
            return string
        return rserialize(root, "")
