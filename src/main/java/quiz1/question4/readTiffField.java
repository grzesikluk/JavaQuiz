package quiz1.question4;
class readTiffFile {
    public static <T> T readTiffField(TiffDirectory directory, TagInfo tagInfo) {
        try {

            final TiffField field = findTiffField(directory, tagInfo);

            if (field == null) {
                return null;
            } else {

                //TiffField.getValue can either return a Short, Integer, Double or an array of those elements.
                if (!field.getValue().getClass().isArray())
                    return (T) (field.getValue());
                else
                    return null;
            }
//        } catch (ImageReadException e) {
////            LOGGER.error("There was an error trying to read field tag");
//            return null;
        } catch (ClassCastException e) {
//            LOGGER.error("Unable to properly cast the field in the required type");
            return null;
        }
    }

    private static TiffField findTiffField(TiffDirectory directory, TagInfo tagInfo) {
        return null;
    }


}




