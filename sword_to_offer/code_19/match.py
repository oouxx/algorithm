#!/usr/bin/env python
# -*- coding: utf-8 -*-


def match(string, pattern):
    if pattern is None:
        return False

    string_index = 0
    pattern_index = 0
    while string_index < len(string) and pattern_index < len(pattern):
        if pattern[pattern_index] == ".":
            string_index += 1
            pattern_index += 1
        else:
            if pattern[pattern_index] == string[string_index] and pattern[
                    pattern_index + 1] == "*":
                string_index += 1
            elif pattern[pattern_index] != string[string_index] and pattern[
                    pattern_index + 1] == "*":
                string_index += 1
                pattern_index += 1
            elif pattern[pattern_index] == string and pattern[pattern_index +
                                                              1] != "*":
                string_index += 1
                pattern_index += 1
            else:
                return False
    return True


if __name__ == "__main__":
    result = match("baaabc", "ba*ab.")
    print(result)
