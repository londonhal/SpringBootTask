package transaction;

class TransactionNotFoundException extends RuntimeException {

	  TransactionNotFoundException(Long id) {
	    super("Could not find transaction " + id);
	  }
	}

