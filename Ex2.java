class Result {
    
    static List<Integer> result = new ArrayList<>();
    static List<Integer> values = new ArrayList<>();
    
    static boolean checker[][] = new boolean[ 1000 ][ 1000 ];
    
    public static int DFS_Visit( int row, int column, int count, List<List<Integer>> grid ) {
        
        int borderX;
        int borderY;
        
        int up_down[] = { 0, -1, 0, 1 };
        int right_left[] = { 1, 0, -1, 0 };
        
        checker[ row ][ column ] = true;
        
        count ++;
        
        for ( int direction = 0; direction < 4; direction ++ ) {
            
            borderX = right_left[ direction ] + row;
            borderY = up_down[ direction ] + column;
            
            if ( ( borderX >= 0 && borderX < grid.size() ) && ( borderY >= 0 && borderY < grid.get( borderX ).size() ) && ( grid.get( borderX ).get( borderY ) ) == 1 && ( ! checker[ borderX ][ borderY ] ) ) {
                
                count = DFS_Visit( borderX, borderY, count, grid );
                
            }
            
        }
        return count;
    }
    
    public static List<Integer> onesGroups( List<List<Integer>> grid, List<Integer> queries ) {
        
        int frequency;
        int value;
        
        for ( int i = 0; i < grid.size(); i ++ ) {
            
            for ( int j = 0; j < grid.size(); j ++ ) {
                
                if ( ( grid.get(i).get(j) ) == 1 && ( ! checker[i][j] ) ) {
                    
                    value = DFS_Visit( i, j, 0, grid );
                    
                    values.add( value );
                    
                }
                
            }
            
        }
        
        for( int i = 0; i < queries.size(); i ++ ){
            
            frequency = 0;
            for( int j = 0; j < values.size(); j ++ ){
                
                if( queries.get(i).equals( values.get(j) ) ){
                    frequency ++;
                }
                
            }
            
            result.add( frequency );
            
        }
        
        return result;
        
    }
    
}
