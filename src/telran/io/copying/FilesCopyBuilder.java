package telran.io.copying;

public class FilesCopyBuilder {
	String type;
	String[] args;

	public FilesCopyBuilder(String type, String[] args) {
		this.type = type;
		this.args = args;
	}

	public static Copy build(String type, String[] args) throws Exception {
		int length = args.length;
		if (length < 2) {
			throw new Exception("Wrong number of arguments");
		}
		return switch (type) {
		case "TransferCopy" -> new TransferCopy(args[0], args[1]);
		case "BufferCopy" -> new BufferCopy(args[0], args[1]);
		case "FilesCopy" -> new FilesCopy(args[0], args[1]);
		default -> throw new IllegalArgumentException("Unsupported copying type: " + type);
		};

	}
}