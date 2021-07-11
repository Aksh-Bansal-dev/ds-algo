find . -name "*.class" -type f 
while true; do
    read -p "Are you sure?(y/n) " yn
    case $yn in
        [Yy]* ) find . -name "*.class" -type f -delete; echo "Cleaned!"; break;;
        [Nn]* ) echo "Bye"; exit;;
        * ) echo "Please answer yes or no.";;
    esac
done
