import java.rmi.UnknownHostException;

import com.mongodb.*;
import org.jongo.Jongo;
import org.jongo.MongoCollection;



public class SavedGameplay {
	
	private DBCollection moves;

	public SavedGameplay() throws UnknownHostException{
		@SuppressWarnings({ "deprecation", "resource" })
		DB db = new MongoClient("localhost", 27017).getDB("SaveGamePlay");
		moves = db.getCollection("MOVES");
	}

	public void add(Move m){
		BasicDBObject document = new BasicDBObject("_id",m.getId() );
		document.append("X_POSITION", m.getxPos());
		document.append("Y_POSITION", m.getyPos());
		document.append("SIGN",  m.getSign().toString());
		
		moves.insert(document);
	}
	
	public void getAllMoves(){
		DBCursor cursor = moves.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void removeAllMoves(){
		DBCursor cursor = moves.find();
		while (cursor.hasNext()) {
			moves.remove(cursor.next());
		}
	}
	
	
}
