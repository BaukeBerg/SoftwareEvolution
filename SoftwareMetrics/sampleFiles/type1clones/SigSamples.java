final class SQLParser {

	SSConnection con;
	private char[] sql;
    private List tokens;
    private int tokenIdx;

    Command parse(SSConnection con, String sqlString) throws SQLException{
    	this.con = con;
      
      /** Multi line comment, single lined */
        Command cmd = parse( sqlString.toCharArray() );
        SQLToken token = nextToken();
        if(token != null){
          // Comment
        	
        	throw createSyntaxError(token, Language.STXADD_ADDITIONAL_TOK);
        }
        return cmd;
        /** Multi
         * 	line
         *  Comment
         */
    }	
	
}