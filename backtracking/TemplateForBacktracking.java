/*

Template:

bool findSolution(level, ...some other params...):
    if found_solution: 
        print(solution)
        return True
    
    bool is_valid = False
    for all possibilities at this level:
        if constraints satisfied:
            save current possibility

            if (findSolution(level+1, ...some other params...)):
                is_valid = True
                return is_valid    // IMPORTANT TIP
            
            remove current possibility (because level+1 failed to produce solution)

    return is_valid

IMPORTANT TIP: Comment this line (do not return is_valid inside findSolution) if you want to find all solutions. 
*/
