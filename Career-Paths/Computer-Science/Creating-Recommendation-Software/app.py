from anime_data import anime_data

def autocomplete(input_text):
    suggestions = []
    for anime in anime_data:
        if anime["title"].lower().startswith(input_text.lower()):
            suggestions.append(anime["title"])
    return suggestions


def get_anime_details(selected_title):
    for anime in anime_data:
        if anime["title"].lower() == selected_title.lower():
            return anime
    return None

def main():
    while True:
        user_input = input("Enter your anime preferences or type 'exit' to quit: ")
        
        if user_input.lower() == 'exit':
            break
        
        recommendations = autocomplete(user_input)
        
        if not recommendations:
            print("No anime found matching your input.")
        else:
            print("Recommended anime titles:")
            for title in recommendations:
                print(title)

if __name__ == "__main__":
    main()